Plannow Technologies
====

Tapestry 5 CKEditor Contribution

This implementation is based on [CKEditor](http://ckeditor.com/).

ckeditor mixin
---------

This contribution provides the following feature:

* Mixin:
  * CKEditor
  
Sample usage
---------------

```html
<t:textArea t:mixins="pn/CKEditor" value="prop:value" parameters="{'toolbar': 'Basic'}" />
```

```html
<t:textArea t:mixins="pn/CKEditor" value="prop:value" parameters="{'toolbar': 'Full'}" />
```

* Note: the value of the parameters attribute is passed to CKEditor's [replace](http://docs.cksource.com/ckeditor_api/symbols/CKEDITOR.html#.replace) method. 

Copyright and license
---------------
Plannow Technologies Tapestry5 CkEditor Project - Copyright 2011 Plannow Technologies, Inc,
licensed under the Apache License version 2.0 as published by the Apache Software Foundation.
