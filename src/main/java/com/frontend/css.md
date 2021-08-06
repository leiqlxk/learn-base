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
7. 后代选择器：通常用单个空格表示，组合了两个选择器，如果第二个选择器匹配的元素具有与第一个选择器匹配的祖先（父母、父母的父母等）元素，则它们被选则
   ``` 
   selector1 selector2 {
   /* property declarations */
   }
   ```
8. 子选择器：当使用>选择符分隔两个元素时，它只会匹配那些作为第一个元素的直接后代（子元素）的第二元素
   ``` 
   元素1 > 元素2 {样式声明 }
   div > span {
   background-color: DodgerBlue;
   }
   ```
9. 通用兄弟选择器：位置无须紧邻，只须同层级，A~B 选择A元素之后所有同层级B元素。
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
