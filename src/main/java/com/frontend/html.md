## 一、文档标签元素

| 元素     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| !DOCTYPE | 定义文档类型                                                 |
| html     | 告知浏览器其自身是一个 HTML 文档                             |
| head     | 定义文档头部                                                 |
| tittle   | 定义文档标题                                                 |
| meta     | 定义元素可提供的有关页面的元信息，比如针对搜索引擎和更新频度的描述和关键字 |
| link     | 引用外部资源，如文档图标、css样式表等                        |
| base     | 与a标签配合使用，指定a标签的根路径                           |
| style    | 定义内联样式表                                               |
| script   | 定义客户端脚本，如JavaScript                                 |
| body     | 定义文档的主体                                               |

## 二、 排版标签元素

| 元素   | 说明                                                         |
| ------ | ------------------------------------------------------------ |
| h1--h6 | 定义标题，最好只使用在标题上，而非因为需要使用粗体及大字号而使用，搜索引擎会根据标题编制索引 |
| p      | 定义段落，浏览器会自动在其前后加空行                         |
| div    | 定义文档中的节，块级元素                                     |
| span   | 定义文档中的节，内联元素                                     |
| br     | 换行                                                         |
| hr     | 水平分割线                                                   |
| iframe | 通过iframe可以在同一个浏览器窗口中显示不止一个页面，src指定不同网页的url，width和height定义iframe的高度和宽度，frameborder属性设置边框 |

## 三、 文本格式化标签元素

| 元素       | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| strong     | 定义加重语气，体现为粗体                                     |
| b          | 定义粗体文本                                                 |
| em         | 定义着重强调文字，体现为斜体文本                             |
| i          | 定义斜体文本                                                 |
| small      | 定义小号字                                                   |
| sub        | 定义为下标文字                                               |
| sup        | 定义为上标文字                                               |
| ins        | 定义插入文字，下划线                                         |
| del        | 定义删除文字，中划线                                         |
| code       | 定义代码块                                                   |
| samp       | 定义代码样板，与code类似                                     |
| kbd        | 定义键盘码                                                   |
| var        | 定义变量                                                     |
| pre        | 定义预格式文本，其内文本会保留空格和换行，而且文本也会呈现等宽字体 |
| abbr       | 定义缩写                                                     |
| address    | 定义地址                                                     |
| bdo        | 覆盖文本方向                                                 |
| blockquote | 定义长的引用                                                 |
| q          | 定义短引用                                                   |
| cite       | 定义引用、引证                                               |
| dfn        | 定义一个项目                                                 |

## 四、 图片标签元素

| 元素 | 说明                                                         |
| ---- | ------------------------------------------------------------ |
| img  | img是空标签，即只有属性没有闭合标签，使用src属性指向图片的url地址，alt属性为图片定义一串预备的可替换文本，width和height属性设置图片的长宽 |
| map  | 用于客户端图像映射，即带有图像可点击区域的一幅图像，img中的usemap属性可引用map标签中的id或name属性，但其决定于浏览器因此应同时加上id和name属性 |
| area | area元素永远嵌套在map元素内部，area元素可定义图像映射中的区域，coords属性规定区域的坐标，href规定区域目标url，shape属性规定区域的形状 |

## 五、 链接标签元素

| 元素 | 说明                                                         |
| ---- | ------------------------------------------------------------ |
| a    | 使用超级链接与网络上的另一个文档相连，点击链接可以从一个页面跳转到另一个页面。其内容可以是一个字，一个词，也可以是一个图片，在标签中使用href属性来描述链接的地址，target属性可以定义被链接文档在何处显示 |
| base | 定义页面上的所有链接规定默认地址或默认目标、也可表示为根路径 |
| link | 定义文档与外部资源的关系                                     |

## 六、 列表标签元素

| 元素 | 说明                             |
| ---- | -------------------------------- |
| ul   | 定义一个无序列表                 |
| ol   | 定义一个有序列表                 |
| li   | 定义有序列表和无序列表里的列表项 |
| dl   | 自定义列表                       |
| dt   | 自定义列表项目                   |
| dd   | 自定义列表描述                   |

## 七、 表格标签元素

| 元素    | 说明           |
| ------- | -------------- |
| table   | 定义表格       |
| caption | 定义表格标题   |
| thead   | 定义表头       |
| tbody   | 定义表格主体   |
| tfoot   | 定义表格页脚   |
| tr      | 定义表格行     |
| th      | 定义表头中的列 |
| td      | 定义表格的列   |

## 八、 表单标签元素

| 元素     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| form     | 定义表单，其是一个包含表单元素的区域，action属性规定提交表单时向何处发送表单数据，autocomplete（on、off）属性规定是否启用表单的自动完成功能，method属性规定用于发送表单数据的http方法为get还是post |
| fieldset | 此标签用于将表单内的相关元素分组，其会在相关的表单元素周围绘制边框，内部使用legend元素来设置fieldset的标题 |
| datalist | 指定一个预先定义的输入控件选项列表                           |
| input    | 其规定了用户可以在其中输入数据的输入字段，输入字段可以通过多种方式改变取决于type属性，可以使用label元素来定义它的标注<br />type(button/checkbox/color/date/datetime/datetime-local/email/file/hidden/image/moth/number/password/radio/range/reset/search/submit/tel/text/time/url/week)：设置input元素的类型<br />value：指定input元素的值<br />autocomplete(on、off)：是否启用自动完成功能<br />autofocus(autofocus)：规定当页面加载时是否自动获得焦点<br />checked(checked)：此属性只针对type为radio或者checkbox时起作用，表示是否预选中<br />disabled(disabled)：规定是否禁用该input元素<br />readonly(readonly)：规定该字段是否为只读字段<br />form(form_id)：其标识该input元素所属一个或多个form表单<br />height：设置input元素的高度<br />width：设置input元素的宽度<br />list：该属性引用datalist元素<br />max(number/date)：规定input元素的最大值<br />maxlength(number)：规定input元素允许的最大字符数<br />min(number/date)：规定input元素的最小值<br />multiple(multiple)：允许用户输入多个值<br />pattern(regexp)：其规定用于验证input元素的值的正则表达式<br />placeholder(text)：该属性规定可描述输入input字段预期值的简短提示语<br />required(required)：规定该字段是否必填<br />size：设置以字符数计的可见宽度<br />src：只针对type为image时使用<br />step：设置type为number时的合法数字间隔 |
| textarea | 定义一个多行的文本输入控件。通过cols和rows来设置它的尺寸，更好的方式是通过css的width和height来设置，maxlength设置允许输入的最大字符数 |
| label    | 为input等元素定义标注即标题，用户点击标题时会自动激活对应的控件，其通过for属性来与相关控件的id关联 |
| select   | 定义下拉选择框                                               |
| optgroup | 用于在select中定义选项组，通过label属性设置它的标题，其内包含option元素 |
| button   | 定义按钮，其type值可以为button、submit、reset                |

