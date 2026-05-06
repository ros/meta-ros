SRC_URI += "${GO_DEPENDENCIES_SRC_URI}"
GO_DEPENDENCIES_SRC_URI = "\
    ${@go_src_uri('github.com/charlievieth/fastwalk','v1.0.12')} \
    ${@go_src_uri('github.com/gdamore/tcell','v2.8.1',path='github.com/gdamore/tcell/v2',pathmajor='/v2')} \
    ${@go_src_uri('github.com/junegunn/go-shellwords','v0.0.0-20250127100254-2aa3b3277741')} \
    ${@go_src_uri('github.com/mattn/go-isatty','v0.0.20')} \
    ${@go_src_uri('github.com/rivo/uniseg','v0.4.7')} \
    ${@go_src_uri('go.googlesource.com/sys','v0.30.0',path='golang.org/x/sys')} \
    ${@go_src_uri('go.googlesource.com/term','v0.29.0',path='golang.org/x/term')} \
    ${@go_src_uri('github.com/gdamore/encoding','v1.0.1')} \
    ${@go_src_uri('github.com/lucasb-eyer/go-colorful','v1.2.0')} \
    ${@go_src_uri('github.com/mattn/go-runewidth','v0.0.16')} \
    ${@go_src_uri('go.googlesource.com/text','v0.21.0',path='golang.org/x/text')} \
"

# github.com/charlievieth/fastwalk@v1.0.12 => fc359aa6488b381ba29e0e6178ab3af36a8eaa90
SRCREV_github.com.charlievieth.fastwalk = "fc359aa6488b381ba29e0e6178ab3af36a8eaa90"
# github.com/gdamore/tcell/v2@v2.8.1 => eed6a79409ffa38c919dc4daf0ca4958e56cb5d4
SRCREV_github.com.gdamore.tcell.v2 = "eed6a79409ffa38c919dc4daf0ca4958e56cb5d4"
# github.com/junegunn/go-shellwords@v0.0.0-20250127100254-2aa3b3277741 => 2aa3b3277741a6ad31883f223d770221a85e9dd0
SRCREV_github.com.junegunn.go-shellwords = "2aa3b3277741a6ad31883f223d770221a85e9dd0"
# github.com/mattn/go-isatty@v0.0.20 => a7c02353c47bc4ec6b30dc9628154ae4fe760c11
SRCREV_github.com.mattn.go-isatty = "a7c02353c47bc4ec6b30dc9628154ae4fe760c11"
# github.com/rivo/uniseg@v0.4.7 => 03509a98a092b522b2ff0de13e53513d18b3b837
SRCREV_github.com.rivo.uniseg = "03509a98a092b522b2ff0de13e53513d18b3b837"
# golang.org/x/sys@v0.30.0 => 863b3c4ac4975ff758815fa8d01acb6771f37177
SRCREV_golang.org.x.sys = "863b3c4ac4975ff758815fa8d01acb6771f37177"
# golang.org/x/term@v0.29.0 => 743b2709ab25357d30ce1eac4a840eb0b7deb1bf
SRCREV_golang.org.x.term = "743b2709ab25357d30ce1eac4a840eb0b7deb1bf"
# github.com/gdamore/encoding@v1.0.1 => 6770ff7f5dae83f6e1bec40dc177c0f347df5139
SRCREV_github.com.gdamore.encoding = "6770ff7f5dae83f6e1bec40dc177c0f347df5139"
# github.com/lucasb-eyer/go-colorful@v1.2.0 => d2b05a0d83cca9d610425691c3253d5f36d0ad06
SRCREV_github.com.lucasb-eyer.go-colorful = "d2b05a0d83cca9d610425691c3253d5f36d0ad06"
# github.com/mattn/go-runewidth@v0.0.16 => 6ceadc68530e7bfea8cba17d6523bed32912d4fa
SRCREV_github.com.mattn.go-runewidth = "6ceadc68530e7bfea8cba17d6523bed32912d4fa"
# golang.org/x/text@v0.21.0 => d42948e5579eb996bedb7df76c7ad57fae4e83c7
SRCREV_golang.org.x.text = "d42948e5579eb996bedb7df76c7ad57fae4e83c7"
