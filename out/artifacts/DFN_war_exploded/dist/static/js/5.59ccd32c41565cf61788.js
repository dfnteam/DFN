webpackJsonp([5],{"12CS":function(t,e){},"9Ryz":function(t,e,i){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=i("woOf"),s=i.n(a),o={data:function(){return{sels:[],UserList:[{Id:"1",name:"asdas",sex:"1",mincome:"123123112",mpay:"14",describe:"1312"}],dialogStatus:"",textMap:{update:"编辑",create:"添加"},dialogFormVisible:!1,editForm:{id:"0",name:"",sex:-1,mincome:0,mpay:"",describe:""}}},methods:{openMask:function(t,e){this.dialogStatus="update",this.dialogFormVisible=!0,this.editForm=s()({},e)},DeleteMask:function(){var t=this;this.$confirm("确认删除该记录吗?","提示",{type:"warning"}).then(function(){t.UserList.splice(index,1),t.$message({message:"删除成功",type:"success"})}).catch(function(){})},batchRemove:function(){var t=this,e=this.sels.map(function(t){return t.id}).toString();this.$confirm("确认删除选中记录吗？","提示",{type:"warning"}).then(function(){batchRemoveUser({ids:e}).then(function(i){t.UserList.split(index,e),t.$message({message:"删除成功",type:"success"})}).catch(function(){})})},updateData:function(){var t=this;this.$refs.editForm.validate(function(e){e&&t.$confirm("确认提交吗？","提示",{}).then(function(){var e=s()({},t.editForm);e.birth=e.birth&&""!=e.birth?util.formatDate.format(new Date(e.birth),"yyyy-MM-dd"):"",t.$message({message:"提交成功",type:"success"}),t.$refs.editForm.resetFields(),t.dialogFormVisible=!1}).catch(function(t){console.log(t)})})},selsChange:function(t){this.sels=t},formatSex:function(t,e){return 1==t.sex?"男":0==t.sex?"女":"未知"},handleAdd:function(){this.dialogStatus="create",this.dialogFormVisible=!0,this.editForm={id:"0",name:"",sex:-1,age:0,phone:"",birth:"",remark:"",addr:""}},createData:function(){var t=this;this.$refs.editForm.validate(function(e){e&&t.$confirm("确认提交吗？","提示",{}).then(function(){t.editForm.id=parseInt(100*Math.random()).toString();var e=s()({},t.editForm);console.log(e),e.birth=e.birth&&""!=e.birth?util.formatDate.format(new Date(e.birth),"yyyy-MM-dd"):"",addUser(e).then(function(e){t.$message({message:"提交成功",type:"success"}),t.$refs.editForm.resetFields(),t.dialogFormVisible=!1,t.getUsers()})}).catch(function(t){console.log(t)})})}}},l={render:function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"container"},[i("div",{staticClass:"top-row"},[i("div",{staticClass:"row"},[t._m(0),t._v(" "),i("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[i("el-form",{attrs:{inline:!0}},[i("el-form-item",[i("el-button",{attrs:{type:"danger",disabled:0===this.sels.length},on:{click:t.batchRemove}},[t._v("批量删除")])],1),t._v(" "),i("el-form-item",[i("el-button",{attrs:{type:"primary"},on:{click:t.handleAdd}},[t._v("新增")])],1)],1)],1),t._v(" "),i("div",{staticClass:"mt-20"},[i("el-table",{staticStyle:{width:"100%"},attrs:{data:t.UserList,"highlight-current-row":""},on:{"selection-change":t.selsChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),t._v(" "),i("el-table-column",{attrs:{type:"index",width:"60"}}),t._v(" "),i("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120",sortable:""}}),t._v(" "),i("el-table-column",{attrs:{prop:"sex",label:"性别",width:"100",formatter:t.formatSex,sortable:""}}),t._v(" "),i("el-table-column",{attrs:{prop:"mincome",label:"搬砖月收入",width:"150",sortable:""}}),t._v(" "),i("el-table-column",{attrs:{prop:"mpay",label:"搬砖月开销",width:"150",sortable:""}}),t._v(" "),i("el-table-column",{attrs:{prop:"describe",label:"搬砖描述","min-width":"120",sortable:""}}),t._v(" "),i("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{size:"small"},on:{click:function(i){t.openMask(e.$index,e.row)}}},[t._v("编辑")]),t._v(" "),i("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(i){t.DeleteMask(e.$index,e.row)}}},[t._v("删除")])]}}])})],1),t._v(" "),i("el-dialog",{attrs:{title:t.textMap[t.dialogStatus],visible:t.dialogFormVisible,"close-on-click-modal":!1},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[i("el-form",{ref:"editForm",attrs:{model:t.editForm,"label-width":"100px"}},[i("el-form-item",{attrs:{label:"姓名",prop:"name"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.editForm.name,callback:function(e){t.$set(t.editForm,"name",e)},expression:"editForm.name"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"性别"}},[i("el-radio-group",{model:{value:t.editForm.sex,callback:function(e){t.$set(t.editForm,"sex",e)},expression:"editForm.sex"}},[i("el-radio",{staticClass:"radio",attrs:{label:1}},[t._v("男")]),t._v(" "),i("el-radio",{staticClass:"radio",attrs:{label:0}},[t._v("女")])],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"搬砖月收入",prop:"mincome"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.editForm.mincome,callback:function(e){t.$set(t.editForm,"mincome",e)},expression:"editForm.mincome"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"搬砖月开销"}},[i("el-input",{model:{value:t.editForm.mpay,callback:function(e){t.$set(t.editForm,"mpay",e)},expression:"editForm.mpay"}})],1),t._v(" "),i("el-form-item",{attrs:{label:"搬砖月描述",prop:"describe"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.editForm.describe,callback:function(e){t.$set(t.editForm,"describe",e)},expression:"editForm.describe"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{nativeOn:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")]),t._v(" "),"create"==t.dialogStatus?i("el-button",{attrs:{type:"primary"},on:{click:t.createData}},[t._v("添加啊")]):i("el-button",{attrs:{type:"primary"},on:{click:t.updateData}},[t._v("提交")])],1)],1)],1)],1)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("nav",{staticClass:"breadcrumb"},[e("i",{staticClass:"Hui-iconfont"},[this._v("")]),this._v(" 搬砖日常管理 \n\t\t\t\t"),e("a",{staticClass:"btn btn-success radius r",staticStyle:{"line-height":"1.6em","margin-top":"3px"},attrs:{href:"javascript:location.replace(location.href);",title:"刷新"}},[e("i",{staticClass:"Hui-iconfont"},[this._v("")])])])}]};var r=i("VU/8")(o,l,!1,function(t){i("12CS")},null,null);e.default=r.exports}});
//# sourceMappingURL=5.59ccd32c41565cf61788.js.map