#!/bin/bash
#
# Copyright (c) 2013 Tobias Weigl, tobias.weigl@bmw-carit.de
# 
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to
# deal in the Software without restriction, including without limitation the
# rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
# sell copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
# FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
# IN THE SOFTWARE.
#
#
# Description
#
# This script provides various functionalities to check and protocol the current
# development state of the meta-ROS layer for Yocto.
#
#
# Global configuration
#
# The script version is printed in the report files for comparability reasons. 
# The script version is a shortened representation of the internal version number.
# If an update is not relevant to the user, the internal version number should be
# increased in the latest sequence, which is not visible in the report files.
internal_version_number='v1.00.006'
script_version=$(echo $internal_version_number | sed 's/.[^.]*$//')
app_name='meta-ROS integration test and report assistant'
authors='Tobias Weigl (tobias.weigl@bmw-carit.de)'
#
# Path information the script uses ('./' for the Yocto project root)
path_to_script_relative_to_project_root='./meta-ros/scripts/'
path_to_topmost_recipes_directory_relative_to_project_root='./meta-ros/recipes-ros/'
path_to_project_root_relative_to_script='./../../'
report_folder_name='../test-reports'
#
# Autodetect
current_script_location="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#
# Autohandle prerequisites
if [[ ! -d "$current_script_location/$report_folder_name"  ]]; then
    mkdir "$current_script_location/$report_folder_name"
fi
#
# Internal vars
txt_file_meta_information_indicator='#'
txt_file_comment_indicator='-'
txt_file_pkg_checking_kw='Checking'
txt_file_pkg_ok_kw='ok'
txt_file_meta_information_kw='Meta information'
#

list_all_available_recipes () {
    find "$path_to_project_root_relative_to_script/$path_to_topmost_recipes_directory_relative_to_project_root/" -name '*.bb'
}

list_all_available_recipes_with_bakeable_name () {
    list_all_available_recipes | sed 's/^.*\///' | sed 's/.bb$//' | sed 's/_.*//'
}

count_available_recipes () {
    list_all_available_recipes | wc -l
}

update_timestamps () {
    # By method call, we work on this timestamp only and just re-format it so we satisfy the constraint that all offered timestamps are based on the exact same time.
    current_timestamp=$(date)

    # Satisfies the constraints: Multiple files can be chronologically ordered by lexical sorting, Windows character set compatible.
    human_readable_timestamp_filename_compatible=$(date --date="$current_timestamp" +%Y'.'%m'.'%d'-'%H'_'%M'_'%S)

    # Satisfies the constraints: Easy and fast to read, no seconds.
    timestamp_pretty_print=$(date --date="$current_timestamp" +%d'.'%m'.'%Y' '%H':'%M)
}

clear_output_file () {
    output_file=$1

    # It is error prone to use a combination of > and >> for file outputs, so we explicitly erase files by calling this method and use only >> afterwards.
    echo -n "" > "$output_file"
}

bake_all () {
    arg=$1

    array=(`list_all_available_recipes_with_bakeable_name`)
    array_length=${#array[*]}
    
    echo -e "\nChecking $array_length recipes."

    # Init the build environment
    cd "$path_to_project_root_relative_to_script"
    build_directory=build
    source ./oe-init-build-env $build_directory

    # Go to the meta-ros git repository location to gather information about commits.
    cd ../meta-ros
    current_git_hash=$(git rev-parse HEAD)

    # The used git command returns an ISO_8601 timestamp. We crop the UTC-offset that can be a pos/neg(hh:mm) value, or Z.

    # Satisfies the constraints: Multiple files can be chronologically ordered by lexical sorting, Windows character set compatible.
    git_date_filename_compatible=$(git show -s --format="%ci" $current_git_hash | sed 's/\ [+ -].*$//' | sed 's/\ Z$//' | sed 's/-/\./g' | sed 's/:/_/g' | sed 's/\ /-/')

    # Satisfies the constraints: Easy and fast to read, no seconds.
    git_date_pretty_print_temp=$(git show -s --format="%ci" $current_git_hash | sed 's/:[0-9][0-9][^:].*$//' | sed 's/-/\./g')
    # The date format comes as year-month-day, but we want day-month-year.
    git_date_year=$(echo $git_date_pretty_print_temp | sed 's/\..*$//')
    git_date_month=$(echo $git_date_pretty_print_temp | sed 's/^[^.]*\.//' | sed 's/\..*$//')
    git_date_day=$(echo $git_date_pretty_print_temp | sed 's/^[^.]*\.[^.]*\.//' | sed 's/\ .*$//')
    git_date_pretty_print="$git_date_day"."$git_date_month"."$git_date_year"' '$(echo $git_date_pretty_print_temp | sed 's/^.*\ //')
    cd ../build

    update_timestamps
    reportname="report-$git_date_filename_compatible"
    report_path_and_name=$current_script_location/$report_folder_name/$reportname
    report_file_raw=$report_path_and_name'.raw'
    report_file_txt=$report_path_and_name'.txt'

    clear_output_file "$report_file_raw"
    clear_output_file "$report_file_txt"

    i=0
    while [ $i -lt $array_length ]; do
	activity="$txt_file_pkg_checking_kw $((i+1))/$array_length: ${array[$i]}"
	echo $activity
        # create clean bitbake environment
	# uncomment the following line if it should always clean the environment
        # for each bitbake run
        # rm bitbake.lock cache/ sstate-cache/ tmp-eglibc/ -rf
	if [ "$arg" = "txt" ]; then
	    # Try to bake every recipe. Store results in a report file. Just give $txt_file_pkg_ok_kw for working recipes, print more information on errors.
	    echo $activity | tee -a "$report_file_raw" >> "$report_file_txt"
	    bitbake ${array[$i]}  | tee -a "$report_file_raw" | grep -i "^NOTE: Tasks Summary\|^Summary:\|^ERROR:\|^WARNING" | sed "s/NOTE.*succeeded\./$txt_file_pkg_ok_kw/" >> "$report_file_txt"
	else
	    # Try to bake every recipe. Just give console output.
	    bitbake ${array[$i]}
	fi
	let i++
    done
    # If there was a text-file generated, compute now also meta information and insert it as header.
    if [ "$arg" = "txt" ]; then
        compute_meta_info_for_txt_file "$report_file_txt" "$current_git_hash" "$git_date_pretty_print" "$timestamp_pretty_print"
    fi

    cd ../"$path_to_script_relative_to_project_root"

    cd "$report_folder_name"
    ln -s -f "$reportname"'.html' ./'Latest_report'
    cd ..
}

compute_meta_info_for_txt_file () {
    report_file_txt=$1
    current_git_hash=$2
    git_date_pretty_print=$3
    timestamp_pretty_print=$4

    first_line=$(head -n 1 "$report_file_txt")

    # Check if the meta information was already computed and the file format is valid.
    if [[ "$first_line" != *"$txt_file_pkg_checking_kw"* ]]; then
	echo "Error computing meta informations for the report."
        return
    fi

    temporary_meta_header='tmp.txt'
    temporary_result_file='tmp_result.txt'
    number_of_recipes=$(echo $(head -n 1 "$report_file_txt") | sed 's/^.*\///' | sed 's/:.*$//')

    number_of_succeeded_recipes=0
    while read line; do
        if [[ "$line" == "$txt_file_pkg_ok_kw" ]]; then
	    let number_of_succeeded_recipes++
        fi
    done < "$report_file_txt"

    recipes_succeded_in_percent=$(($(($number_of_succeeded_recipes*100))/$number_of_recipes))

    clear_output_file "$temporary_meta_header"

    # To allow for greedy parsing later on, these lines have to be extended or modified carefully.
    echo "$txt_file_comment_indicator""$txt_file_comment_indicator""$txt_file_comment_indicator" >> "$temporary_meta_header"
    echo "$txt_file_comment_indicator""$txt_file_meta_information_kw" >> "$temporary_meta_header"
    echo "$txt_file_meta_information_indicator""Report generation date: $timestamp_pretty_print" >> "$temporary_meta_header"
    echo "$txt_file_meta_information_indicator""Recipes succeeded: $number_of_succeeded_recipes of $number_of_recipes, equaling ""$recipes_succeded_in_percent""%" >> "$temporary_meta_header"
    echo "$txt_file_meta_information_indicator""Git hash: $current_git_hash" >> "$temporary_meta_header"
    echo "$txt_file_meta_information_indicator""Git commit date: $git_date_pretty_print" >> "$temporary_meta_header"
    echo "$txt_file_meta_information_indicator""General Info: This report was generated using the $app_name $script_version" >> "$temporary_meta_header"
    echo "$txt_file_comment_indicator""$txt_file_comment_indicator""$txt_file_comment_indicator" >> "$temporary_meta_header"

    cat "$temporary_meta_header" "$report_file_txt" > "$temporary_result_file"
    rm "$report_file_txt"
    rm "$temporary_meta_header"
    mv "$temporary_result_file" "$report_file_txt"
}

# Provides a greedy txt-parser that writes an xml-file.
txtdata2xml () {
    report_file_txt=$1

    if [ "$report_file_txt" == "" ]; then
        echo "There was an error reading the necessary txt-file for creating the xml-file."
        return
    fi

    report_file_xml=$(echo "$report_file_txt" | sed 's/txt$/xml/')

    clear_output_file "$report_file_xml"

    echo '<?xml version="1.0"?>' >> "$report_file_xml"
    echo '<report>' >> "$report_file_xml"
    while read line; do
        if [[ "$line" == *"$txt_file_pkg_checking_kw"* ]]; then
	    if [[ "$line" != *"$txt_file_pkg_checking_kw"\ 1/* ]]; then
	        echo "    </report_item>" >> "$report_file_xml"
	    fi
	    echo "    <report_item>" >> "$report_file_xml"
	    echo "        <package>"$(echo $line | sed 's/^.*:\ //')"</package>" >> "$report_file_xml"
        elif [[ "$line" == *"$txt_file_pkg_ok_kw"* ]]; then
	    echo "        <result_line>$line</result_line>" >> "$report_file_xml"
        elif [[ "$line" == "$txt_file_meta_information_indicator"* ]]; then
	    echo "    <meta_info>""$(echo $line | sed 's/^.//')""</meta_info>" >> "$report_file_xml"
        elif [[ "$line" == "$txt_file_comment_indicator"* ]]; then
	    :
        else
	    echo "        <result_line>$line</result_line>" >> "$report_file_xml"
        fi
    done < "$report_file_txt"
    echo "    </report_item>" >> "$report_file_xml"
    echo "</report>" >> "$report_file_xml"
}

# Provides a greedy xml-parser that writes an html report.
xml2html () {
    report_file_xml=$1

    if [ "$report_file_xml" == "" ]; then
        echo "There was an error reading the necessary xml-file for creating the html-file."
        return
    fi

    report_file_html=$(echo "$report_file_xml" | sed 's/xml$/html/')

    clear_output_file "$report_file_html"

### start multi-line echo
    echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="file created by" content="'"$app_name"'" />
<meta name="author" content="'"$authors"'" />
<title>meta-ROS - bitbake report</title>
<style type="text/css">
.report {
background-color:#FAFAFA;
}
.pkg {
padding: 20px 0 0 20px;margin: 0 -20px 0 0;width:20%;float:left;
}
.result_line {
width:80%;float:right;
}
.meta_info {
text-align:center;background-color:#EEE;
}
ul {
overflow: hidden;
}
.report_item {
border-bottom-color:#DDD;border-bottom-style:solid;border-bottom-width:1px;
}
</style>
</head>
<body>
<div style="width:80%; margin:0 auto;box-shadow: 5px 5px 3px #888;border-color:#BBB;border-style:solid;border-width:1px;">
    <div style="border-bottom-color:#BBB;border-bottom-style:solid;border-bottom-width:1px;text-shadow: 2px 2px 1px #BBB;background-color:#E0E0FF;height:30px;text-align:center;font-size:150%">meta-ROS - bitbake report</div>
    <div class="meta_info" style="padding:10px 0 10px 0;font-weight:bold">Available meta information:</div>' >> "$report_file_html"
### end multi-line echo

    while read line; do
        if [[ "$line" == *\<report\>* ]]; then
            echo '<div class="report">' >> "$report_file_html"
        elif [[ "$line" == *\<meta_info\>* ]]; then
            clean_meta_info=$( echo $line | sed 's/.*<meta_info>//' | sed 's/<\/meta_info>//' )
            if [[ "$clean_meta_info" == *General\ Info* ]]; then
                echo '    <div class="meta_info" style="padding-bottom:10px">'"$clean_meta_info"'</div>' >> "$report_file_html"
            else
                echo '    <div class="meta_info">'"$clean_meta_info"'</div>' >> "$report_file_html"
            fi
        elif [[ "$line" == *\<report_item\>* ]]; then
            echo '    <div class="report_item">' >> "$report_file_html"
        elif [[ "$line" == *\<package\>* ]]; then
            echo -n '        <div class="pkg">' >> "$report_file_html"
	    echo -n "$line" | sed 's/<package>//' | sed 's/<\/package>//' >> "$report_file_html"
            echo '</div>' >> "$report_file_html"
            echo '        <div class="result_line">' >> "$report_file_html"
            echo '            <ul>' >> "$report_file_html"
        elif [[ "$line" == *\<result_line\>* ]]; then
            no_tags_line=$(echo $line | sed 's/.*<result_line>//' | sed 's/<\/result_line>.*$//')
	    if [[ "$no_tags_line" == "$txt_file_pkg_ok_kw"* ]]; then
	        echo -n '                <li style="width:95%;background-color:#AEA">'"$no_tags_line" >> "$report_file_html"
	    elif [[ "$no_tags_line" == Summary*Error* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EAA">'"$no_tags_line" >> "$report_file_html"
            elif [[ "$no_tags_line" == Summary*failed* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EAA">'"$no_tags_line" >> "$report_file_html"
            elif [[ "$no_tags_line" == NOTE*failed* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EAA">'"$no_tags_line" >> "$report_file_html"
	    elif [[ "$no_tags_line" == Summary*Warning* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EEA">'"$no_tags_line" >> "$report_file_html"
	    elif [[ "$no_tags_line" == *WARNING* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EEA">'"$no_tags_line" >> "$report_file_html"
	    elif [[ "$no_tags_line" == *ERROR* ]]; then
	        echo -n '                <li style="width:95%;background-color:#EAA">'"$no_tags_line" >> "$report_file_html"
	    else
	        echo -n '                <li style="width:95%;background-color:#EEA">'"$no_tags_line" >> "$report_file_html"
	    fi
            echo '</li>' >> "$report_file_html"
        elif [[ "$line" == *\</report\>* ]]; then
            echo '</div>' >> "$report_file_html"
        elif [[ "$line" == *\</report_item\>* ]]; then
            echo '            </ul>' >> "$report_file_html"
            echo '        </div>' >> "$report_file_html"
            echo '    </div>' >> "$report_file_html"
            echo '    <div style="clear:both"></div>' >> "$report_file_html"
        fi
    done < "$report_file_xml"

### start multi-line echo
    echo '    <div style="background-color:#E0E0FF;height:5px;text-align:center;font-size:50%"></div>
</div>
</body>
</html>' >> "$report_file_html"
### end multi-line echo
}

convert_all_available_xml_files_to_html_files () {
    array=(`find "$report_folder_name/" -name '*.xml'`)
    array_length=${#array[*]}

    if [[ $array_length -lt 1 ]]; then
        echo 'Error creating html-files: There are no xml-files available for conversion!'
    else
        echo "Creating $array_length new html-files!"
        i=0
        while [ $i -lt $array_length ]; do
            xml2html "${array[$i]}"
            let i++
        done
    fi
}

convert_all_available_txt_files_to_xml_files () {
    array=(`find "$report_folder_name/" -name '*.txt'`)
    array_length=${#array[*]}

    if [[ $array_length -lt 1 ]]; then
        echo 'Error creating xml-files: There are no txt-files available for conversion!'
    else
        echo "Creating $array_length new xml-files!"
        i=0
        while [ $i -lt $array_length ]; do
            txtdata2xml "${array[$i]}"
            let i++
        done
    fi
}

# Provides a greedy txt-parser that writes an html meta-report.
convert_all_available_txt_files_to_html_meta_report () {
    # It is important here that all reports are chronologically sorted so that the meta report is easily understandable.
    # Since the date format was chosen adequately, this can be achieved with sort -r.
    array=(`find "$report_folder_name/" -name '*.txt' | sort -r`)
    array_length=${#array[*]}

    if [[ $array_length -lt 1 ]]; then
        echo 'Error creating meta-report: There are no reports available for interpretation!'
        return
    fi
    echo "Creating new meta-report from $array_length txt-files!"

    update_timestamps
    reportname="meta-report-$human_readable_timestamp_filename_compatible"
    report_path_and_name=$current_script_location/$report_folder_name/$reportname
    meta_report_file_html=$report_path_and_name'.html'

    clear_output_file "$meta_report_file_html"

### start multi-line echo
    echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="file created by" content="'"$app_name"'" />
<meta name="author" content="'"$authors"'" />
<title>meta-ROS - bitbake meta report</title>
<style type="text/css">
.report {
background-color:#FAFAFA
}
.meta_report_file_html {
padding: 20px 0 0 20px;margin: 0 -20px 0 0;width:50%;float:left;
}
.result_line {
padding: 5px 0 5px 0;width:50%;float:right;
}
.meta_info {
text-align:center;background-color:#EEE;
}
.result_item {
text-align:center;
}
.progressbar_bkg {
margin:0 auto;width:100px;height:10px;background-color:#888;border-color:#555;border-style:solid;border-width:1px;
}
.progressbar_outer_filling {
height:10px;border-right-width:2px;border-right-color:#CFB862;border-right-style:solid;
}
.progressbar_inner_filling {
height:10px;background-color:#00F800;float:left;
}
ul {
overflow: hidden;
}
.report_item {
border-bottom-color:#DDD;border-bottom-style:solid;border-bottom-width:1px;
}
</style>
</head>
<body>
<div style="width:80%; margin:0 auto;box-shadow: 5px 5px 3px #888;border-color:#BBB;border-style:solid;border-width:1px;">
    <div style="border-bottom-color:#BBB;border-bottom-style:solid;border-bottom-width:1px;text-shadow: 2px 2px 1px #BBB;background-color:#E0E0FF;height:30px;text-align:center;font-size:150%">meta-ROS - bitbake meta report</div>
    <div class="meta_info" style="padding:10px 0 10px 0;font-weight:bold" >Available meta information:</div>
<div class="report">
    <div class="meta_info">Report generation date: '"$timestamp_pretty_print"'</div>
    <div class="meta_info" style="padding-bottom:10px">General Info: This meta report was generated using the '"$app_name $script_version"'</div>' >> "$meta_report_file_html"
### end multi-line echo

    # Check the number of recipes of the latest commit. It is the benchmark value for the relative_build_process_progress_percentage.
    number_of_recipes_of_latest_commit_extract ${array[0]}

    # Check all available reports.
    i=0
        reports_succeeded=0
    while [ $i -lt $array_length ]; do
        txtdata2meta_report "${array[$i]}" "$meta_report_file_html"
        let i++
    done

        # If there were errors reading the meta informations of a text file, display an error message.
    if [[ $reports_succeeded -lt $array_length ]]; then
        echo "Succeeded for $reports_succeeded!"
    fi

    echo '</div>' >> "$meta_report_file_html"
    echo '    <div style="background-color:#E0E0FF;height:5px;text-align:center;font-size:50%"></div>' >> "$meta_report_file_html"
    echo '</div>' >> "$meta_report_file_html"
    echo '</body>' >> "$meta_report_file_html"
    echo '</html>' >> "$meta_report_file_html"

    cd "$report_folder_name"
    ln -s -f "$reportname"'.html' ./'Latest_meta-report'
    cd ..
}

number_of_recipes_of_latest_commit_extract () {
    latest_commit_report_file=$1

    while read line; do
        if [[ "$line" == \#Recipes\ succeeded* ]];then
            number_of_recipes_of_latest_commit=$(echo "$line" | sed 's/^.*of\ //' | sed 's/,.*$//')
        fi
    done < "$latest_commit_report_file"
}

txtdata2meta_report () {
    sub_report_txt=$1
    meta_report_file_html=$2

    # Check if the text report has meta informations. If not, it is probably uncomplete or in progress and we reject it.
    second_line=$(head -n 2 "$sub_report_txt")
    if [[ "$second_line" != *"$txt_file_meta_information_kw"* ]];then
        return
    fi

    let reports_succeeded++

    while read line; do
        if [[ "$line" == \#Recipes\ succeeded* ]];then
            succeeded_recipes=$(echo "$line" | sed 's/^#Recipes succeeded:\ //' | sed 's/\ of.*$//')
            recipes_checked=$(echo "$line" | sed 's/^.*of\ //' | sed 's/,.*$//')
            # For graphical rendering reasons, the outer bar of the progress bar can be at most 98px, since it has a 2px right-border.
            current_commit_build_process_progress_percentage=$(echo "$line" | sed 's/^.*equaling\ //'| sed 's/%.*$//')
            let98_current_commit_build_process_progress_percentage=$current_commit_build_process_progress_percentage
            if [[ $let98_current_commit_build_process_progress_percentage -gt 98 ]]; then
                let98_current_commit_build_process_progress_percentage=98
            fi
        elif [[ "$line" == \#Git\ hash:\ * ]];then
            githash=$(echo "$line" | sed 's/^#Git hash:\ //')
        elif [[ "$line" == \#Git\ commit\ date:\ * ]];then
            git_date_pretty_print=$(echo "$line" | sed 's/^#Git\ commit\ date:\ //')
        fi
    done < "$sub_report_txt"

    # Semantic convention for the meta report: The relative progress of a commit is min(arg1, arg2) in
    # arg1: (successfully built recipes/the latest commit's number of recipes) in percent,
    # arg2: (successfully built recipes/the current commit's number of recipes) in percent.
    relative_build_process_progress_percentage1=$(($(($succeeded_recipes*100))/$number_of_recipes_of_latest_commit))
    relative_build_process_progress_percentage2=$current_commit_build_process_progress_percentage

    if [[ relative_build_process_progress_percentage1 -gt relative_build_process_progress_percentage2 ]]; then
        relative_build_process_progress_percentage=$relative_build_process_progress_percentage2
    else 
        relative_build_process_progress_percentage=$relative_build_process_progress_percentage1
    fi

    echo '    <div class="report_item">
        <div class="meta_report_file_html">Git commit date: '"$git_date_pretty_print"'</div>
        <div class="result_line">
            <div style="padding:10px">
                <div class="progressbar_bkg">
                    <div class="progressbar_outer_filling" style="width:'"$let98_current_commit_build_process_progress_percentage"'px">
                        <div class="progressbar_inner_filling" style="width:'"$relative_build_process_progress_percentage"'px"></div>
                    </div>
                </div>
            </div>
            <div class="result_item">Recipes succeeded: '"$succeeded_recipes"' of '"$recipes_checked"', equaling '"$current_commit_build_process_progress_percentage"'% <span style="color:#888">(rel.: '"$relative_build_process_progress_percentage"'%)</span></div>
            <div class="result_item">Git hash: '"$githash"'</div>
        </div>
    </div>
    <div style="clear:both"></div>' >> "$meta_report_file_html"
}

bake () {
    bake_all
}

bake_txtfile () {
    bake_all txt
}

bake_xmlfile () {
    bake_all txt
    txtdata2xml "$report_path_and_name"'.txt'
}

bake_htmlfile () {
    bake_all txt
    txtdata2xml "$report_path_and_name"'.txt'
    xml2html "$report_path_and_name"'.xml'
}

bake_html_and_metafile () {
    bake_htmlfile
    convert_all_available_txt_files_to_html_meta_report
}

create_htmlmetafile () {
    convert_all_available_txt_files_to_html_meta_report
}

eval_args () {
    args=$1

    for arg in $args ; do
	case "$arg" in
	    --ls)
		list_all_available_recipes ;;
	    --lb)
		list_all_available_recipes_with_bakeable_name ;;
	    --bc)
		count_available_recipes ;;
	    --b) 
		bake ;;
	    --btxt) 
		bake_txtfile ;;
	    --bxml) 
		bake_xmlfile ;;
	    --bhtml) 
		bake_htmlfile ;;
	    --bhtmlmeta) 
		bake_html_and_metafile ;;
	    --htmlmeta) 
		create_htmlmetafile ;;
	    --t2x) 
		convert_all_available_txt_files_to_xml_files ;;
	    --x2h)
		convert_all_available_xml_files_to_html_files ;;
	    --help) eval_args -h ;;
	    -h)
		show_help ;;
	    *)
		echo "Unknown command." ;;
        esac
    done
}

show_help () {
    clear
    echo "Name:"
    echo "Integration test and report assistant for the meta-ROS layer"
    echo ""
    echo "Description:"
    echo "--b: Bake all recipes and give console output"
    echo "--bc: Count available meta-ROS recipes"
    echo "--bhtml: Bake all recipes and save results to time-stamped html-file"
    echo "--bhtmlmeta: Execute bhtml, htmlmeta"
    echo "--btxt: Bake all recipes and save results to time-stamped txt+raw-files"
    echo "--bxml: Bake all recipes and save results to time-stamped xml-file"
    echo "--help or -h: Show this help page"
    echo "--htmlmeta: Generate time stamped meta-report over all available reports"
    echo "--ls: List available meta-ROS recipes with full name"
    echo "--lb: List available meta-ROS recipes with bakeable name"
    echo "--t2x: Create xml-reports for all available txt-reports"
    echo "--x2h: Create html-reports for all available xml-reports"
    echo ""
    echo "Run the script using a described option as command line argument"
    echo "No argument executes standard action: "$standard_action
}

#main call
standard_action='--bhtmlmeta'
if [ $# -eq 0 ]; then
    eval_args $standard_action
elif [ $# -eq 1 ]; then
    eval_args $1
else
    echo "Error: Too many arguments."
fi
