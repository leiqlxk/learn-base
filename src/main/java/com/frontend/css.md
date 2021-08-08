### css：层叠样式表（cascading style sheet）
1. 官方文档：https://www.w3.org/
2. MDN：https://developer.mozilla.org/zh-CN/
3. caniuse：https://caniuse.com/#home
4. css编码： @charset 'utf-8'
### 使用方式
1. 内联样式：直接以属性的形式写在html标签内 
    ``` 
        <div style="color:red;">div</div>
    ```
2. 内联样式表：放在head元素内集中管理
    ``` 
        <head>
            <style type="text/css">
                div {
                   color: red;
                }
            </style>
        </head>
    ```
3. 外联样式表：通过link标签或@imort引入的外部css文件
    ```
       <head>
           <link rel="stylesheet" href="./test.css"/>
   
           <style type="text/css">
                @import url(./test.css)
           </style>
       </head> 
    ```
### css基础选择器
1. 通配选择器：通配选择器匹配所有元素,其可以和任意选择器一起使用，但和直接使用其他选择器效果一样，如*.warning和.warning效果完全相同
    ``` 
        <style type="text/css">
            *[lang^=en]{color:green;}
            *.warning {color:red;}
            *#maincontent {border: 1px solid blue;}
            * {
                color: red
             }
            /* 在css3中可以和内部空间组合使用，
                1. ns|*：会匹配到ns空间下的所有元素
                2. *|*：会匹配到所有空间下的所有元素
                3. |*：会匹配到所有没有空间的元素
            */
        </style>
    ```
2. 元素选择器：通过节点名称匹配元素
   ``` 
      元素 {样式声明 }
      span {
           background-color: DodgerBlue;
           color: #ffffff;
      }
   ```
3. 类选择器：过元素上的class属性来匹配以.开始
     ``` 
        <style type="text/css">
            .类名 {样式声明 }
   
            .class-name {
                color: red;
             }
        </style>
    ```
4. id选择器：通过元素上的id属性来匹配以#开头
     ``` 
        <style type="text/css">
            #id属性值 {样式声明 }
   
            #id {
                color: red;
             }
        </style>
    ```
5. 属性选择器：通过已经存在的属性名或属性值匹配属性元素
   * [attr]：表示带有以 attr 命名的属性的元素
   * [attr=value]：表示带有以 attr 命名的属性，且属性值为 value 的元素
   * [attr~=value]：表示带有以 attr 命名的属性的元素，并且该属性是一个以空格作为分隔的值列表，其中至少有一个值为 value
   * [attr|=value]：表示带有以 attr 命名的属性的元素，属性值为“value”或是以“value-”为前缀
   * [attr^=value]：表示带有以 attr 命名的属性，且属性值是以 value 开头的元素
   * [attr$=value]：表示带有以 attr 命名的属性，且属性值是以 value 结尾的元素
   * [attr*=value]：表示带有以 attr 命名的属性，且属性值至少包含一个 value 值的元素
   * [attr operator value i]：在属性选择器的右方括号前添加一个用空格隔开的字母 i（或 I），可以在匹配属性值时忽略大小写
   ``` 
   /* 存在title属性的<a> 元素 */
   a[title] {
   color: purple;
   }
   
   /* 存在href属性并且属性值匹配"https://example.org"的<a> 元素 */
   a[href="https://example.org"] {
   color: green;
   }
   
   /* 存在href属性并且属性值包含"example"的<a> 元素 */
   a[href*="example"] {
   font-size: 2em;
   }
   
   /* 存在href属性并且属性值结尾是".org"的<a> 元素 */
   a[href$=".org"] {
   font-style: italic;
   }
   
   /* 存在class属性并且属性值包含以空格分隔的"logo"的<a>元素 */
   a[class~="logo"] {
   padding: 2px;
   }
   ```
6. 选择器列表（并集选择器或并集组合器以,隔开）：选择所有能被列表中的任意一个选择器选中的
   ``` 
   element, element, element { style properties }
   /* 选择所有 <span> 和 <div> 元素 */
   span, div {
   border: red 2px solid;
   }
   ```
7. 交集选择器
   ```
   选择器直接连接，中间无空格如下表示两个选择器同时满足
   selector1selector2{
   }
   ```
8. 后代选择器：通常用单个空格表示，组合了两个选择器，如果第二个选择器匹配的元素具有与第一个选择器匹配的祖先（父母、父母的父母等）元素，则它们被选则
   ``` 
   selector1 selector2 {
   /* property declarations */
   }
   ```
9. 子选择器：当使用>选择符分隔两个元素时，它只会匹配那些作为第一个元素的直接后代（子元素）的第二元素
   ``` 
   元素1 > 元素2 {样式声明 }
   div > span {
   background-color: DodgerBlue;
   }
   ```
10. 通用兄弟选择器：位置无须紧邻，只须同层级，A~B 选择A元素之后所有同层级B元素。
    ``` 
    p ~ span {
    color: red;
    }
    ```
11. 相邻兄弟选择器：以+分隔两个选择器，当第二个元素紧跟在第一个元素之后，并且两个元素都是同属于同一个父元素，则第二个元素被选中
    ```
    former_element + target_element { style properties }
   
    /* 图片后面紧跟着的段落将被选中 */
    img + p {
    font-style: bold;
    }
    ```
### 伪类和伪元素
1. 伪类（pseudo-classes）：不需要想class一样在元素上标注，常见的伪类有：
   * 动态伪类（dynamic pseudo-classes）：注意编写顺序为LVFHA，否则可能会导致有些选择器不生效
     * :link一般用于a标签表示未访问
     * :visited一般用于a标签表示已访问
     * :hover可以用在a元素以外的其它元素表示鼠标悬浮于元素之上
     * :active可以用在a元素以外的其它元素表示鼠标选中该元素左键并未放开
     * :focus通常用于表单元素，获取到焦点，注意a元素也有焦点可用tab键切换到a元素上
   * 目标伪类（target pseudo-classes）：
     * :target可以选中被选中的锚点
   * 语言伪类（language pseudo-classes）：
     * :lange()
   * 元素状态伪类（UI element states pseudo-classes）：
     * :enabled
     * :disabled
     * :checked
   * 结构伪类（structural pseudo-classes）：
     * :nth-child()参数为数字，选中第几个子元素；参数为n时，n代表自然数（0,1,2,3.....），即代表所有子元素；参数为2n时则表示偶数（2,4,6,8....）；2n+1或2n-1为奇数，为负数时表示前几个如-n+3，参数是n时依此类推
     * :nth-last-child()方向与nth-child相反，即倒着数
     * :nth-of-type()其会排除不是要选中的元素类型，如p:nth-of-type(3)，它只管子元素是p元素的，其它类型的不管直接忽略
     * :nth-last-of-type()方向与上相反
     * :first-child第一个子元素
     * :last-child最后一个子元素
     * :first-of-type第一个各种类型的子元素
     * :last-of-type最后一个各种类型的子元素
     * :root根元素就是html元素
     * :only-child父元素中的唯一子元素
     * :only-of-type父元素中唯一该类型的子元素
     * :empty元素内容为空
   * 否定伪类（negation pseudo-classes）：
     * :not()括号中为一个简单选择器
2. 伪元素（pseudo-classes）单冒号双冒号都可以，便于与伪类区分使用双冒号，伪元素可以看成行内元素，宽度高度对其无效
   * ::first-line第一行
   * ::first-letter第一个字符
   * ::before其中可以使用content属性在元素的前面加入内容，且直接在这个选择器中可以设置该伪元素的相关属性
   * ::after在元素的后面加入内容，其和::before一样context内容即使为空也不能删除content否则无效
### css属性
1. 常用属性
   * color：前景色，字体颜色
   * font-size：字体大小，单位可以为px，em，rem和百分比等，google默认字体大小为16px
   * background-color:：背景色
   * width/height：宽度和高度，其对内联元素无效，值为百分比时相对的应该是它的包含块
   * outline：类似于border，但其只是边框的轮廓不会增加元素的大小，经常用在div可以作为调试技巧看页面布局
2. 文本属性（通常子元素会继承）
   * text-decoration：用于设置文字的装饰线。值为：无任何装饰线（none）、上划线（overline）、下划线（underline）、删除线（line-through）
   * text-transform：用于设置文字的大小写转换，值为：没有任何影响（none）、每个单词首字符变为大写（capitalize）、所有字符大写（uppercase）、所有字符小写（lowercase）
   * text-indent：首行缩进，值可以为px、em、rem（根元素的字体大小root em）等，在text-indent中时em为此文本自己的字体大小，即1em为一个字的大小
   * text-align：设置元素内容在元素中的水平方式，其值为左对齐（left）、右对齐（right）、居中（center）、两端对齐但是它对最后一行没有效果要设置最后一行的话要使用text-align-last（justify）
   * letter-spacing：字母间距
   * word-spacing：单词间距
3. 文字属性（通常子元素会继承）
   * font-size：字体大小，这里面的em和百分都是相对于父元素的font-size大小，1em为100%，2em为200%
   * font-family：设置文字的字体，为了防止设置的字体刚好操作系统中不存在我们可以设置多个字体用逗号隔开，其会从头开始找直到找到为止，如果都没有则使用默认字体。一般情况下英文字体只适用英文，中文字体既支持中文也支持英文，那么如果就是想分别使用不一样的中英文字体则要把英文字体放在前面
   * font-weight：设置文字的粗细，值为100|200|300|400|500|600|700|800|900，每个数字表示一个重量，特殊值normal（400）、bold（700）
   * font-style：设置文字的常规、斜体显示，值为常规显示（normal）、字体的斜体显示前提是字体本身支持斜体（italic）、文本倾斜显示其为让文字倾斜（oblique）
   * font-variant：可以影响小写字母的显示形式，值为normal、small-caps（将小写字母替换为缩小过的大写字母）
   * line-height：设置文本的最小行高，可以简单理解为一行文字所占据的高度，严格来说其为两行文字基线之间的间距，因为行距为等分所以它就是一行文字的高度，height为元素整体的高度，注意区分。行高可以用来做垂直居中，当height和line-height相等时就居中了
   * font：是一个缩写属性，可以一次性设置以上的所有属性，字体大小和行高的设置方式为font-size/line-height，并且font-family必须在其后面，其他三个属性在其前面顺序随意
### css特性
1. 继承：一个元素如果没有设置某属性，就会跟随父元素的值，如果自身有设置值则使用自身设置的值，宽、高、背景色等属性不会继承，但可以使用inherit来强制继承。**注意css属性继承的是计算值而不是字面量** 
2. 层叠：css允许多个相同名字的css属性层叠在同一个元素上
   * 基本层叠（相同的选择器）：后面写的属性会把前面写的属性层叠掉
   * 当选择器不同时就不能按照基本层叠来理解，每个选择器都有自己对应的权重，权重越高就使用谁。通常我们使用以下方式来计算个选择器的权重，只是通常这么做非严格定义，比较的时候从优先级高的选择器开始比较：
     * !important可以认为权重为10000，即可以使用其来排除元素从框架等其他地方获得的属性
     * 内联样式权重可认为1000
     * id选择器的权重为100
     * 类选择器、属性选择器、伪类选择器的权重为10
     * 元素、伪元素选择器的权重为1方便计算
     * 通配符为0
### 颜色设置
1. 英文单词，即基本颜色的关键字，如red、green、black、blue等，但其表现的颜色种类有限
2. RGB颜色：即以红（red）、绿色（green）、蓝色（blue）三个颜色的通道变化及叠加来得到各式各样的颜色
   * 十进制表示时每个颜色的取值范围为0~255，表示方法为rgb(0, 0, 0)所有都是0的情况为黑色，所有都为255时为白色
   * 十六进制表示时每个颜色的取值范围为0~ff，写法为#ffffff的形式，#0f0此种形式表示#00ff00的简写
3. RGBA中的a为alpha，设置透明度，其值为0~1，为1时完全不透明，为零时完全透明
4. 当background-color:transparent,表示rgba全为0，即全透明
### emmet语法：使用tab键快速生成
1. 生成html元素
   * !和html:5都可以快速生成html5文件结构
   * 生成子代的元素：div > p > span > strong
   * 生成兄弟元素：h2 + div + p
   * 上一层级：^
   * 生成多个：*
   * 分组：()
   * 属性：类使用.，id使用#，普通属性使用[]多个使用空格隔开，生成多个元素时可以使用$占位符生成下标值从1开始
   * 内容：{}，生成多个元素时可以使用$占位符生成下标值从1开始
   * 隐式标签：当什么都不写时默认为div标签如.wrap生成`<div class="wrap"></div>`；另外如ul、ol之类的内部固定为li标签，则内部的li也可以省略
2. 生成css，正常为首字母缩写
   * 生成基本属性：w20+h30+m40+p10，则分别生成width、height、margin、padding
   * fz：font-size
   * fw：font-weight
   * lh：line-height
   * bgc：background-color
