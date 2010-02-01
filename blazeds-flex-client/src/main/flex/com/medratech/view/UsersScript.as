
import com.medratech.view.user.AddUser;
import com.medratech.bean.User;
import flash.events.Event;
import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.utils.ArrayUtil;


[Bindable] 
private var userList:ArrayCollection;

[Bindable]
private var popup:AddUser = new AddUser();
 
private function resultHandler(event:ResultEvent):void {
     userList = event.result as ArrayCollection;
}
 
private function faultHandler(event:FaultEvent):void {
     Alert.show(event.fault.message);
}

private function addNewUser():void {
	popup.addEventListener("addNewUser", addUser);
	PopUpManager.addPopUp(popup, this, true);
    PopUpManager.centerPopUp(popup);
}

private function addUser(event:Event):void {
	remoteObject.add(popup.username.text, popup.realname.text, popup.email.text, popup.pass1.text);
}

private function deleteUser():void {
	remoteObject.del(userDG.selectedItem as User);
}

