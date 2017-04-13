<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<form id="frm_idxrate" method="post">
	<table cellpadding="5">
		<tr>
			<td>参数：</td>
			<td>
				<input id="id_parmid" class="easyui-textbox" type="text" name="parmid" data-options="required:true"></input>
				<input id="id_id" class="easyui-textbox" type="hidden" name="id"></input>
			</td>
		</tr>
		<tr>
			<td>适用店铺：</td>
			<td><input id="id_forshop" class="easyui-textbox" type="text" name="forshop" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>使用品类：</td>
			<td><input id="id_forcat" class="easyui-textbox" type="text" name="forcat" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>使用对象：</td>
			<td><input id="id_forobj" class="easyui-textbox" type="text" name="forobj" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>参数值：</td>
			<td><input id="id_parmvalue" class="easyui-textbox" type="text" name="parmvalue" data-options="required:true"></input></td>
		</tr>
		<tr>
			<td>创建人：</td>
			<td><input id="id_creator" class="easyui-textbox" type="text" name="creator" data-options="required:true"></input></td>
		</tr>
	</table>
</form>
<script>
BSS.dispatch({code:18015,data:[{id:'${id}'}]},function(resp){
	BSS.json2form('#frm_idxrate',resp.data[0]);
});
IDXRATEDIALOG.ok = function(){
	var idxrate = BSS.form2json('#frm_idxrate');
	BSS.dispatch({code:18008,data:[idxrate]},function(){
		BSS.alert('保存成功！');
	},function(){});
}
</script>