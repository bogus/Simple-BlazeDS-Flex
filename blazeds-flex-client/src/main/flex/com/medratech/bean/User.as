package com.medratech.bean
{
	
	[Bindable]
	[RemoteClass(alias="com.medratech.model.impl.User")]
	public class User
	{
		public var id:int;
		public var vesion:int;
		public var username:String;
	    public var realname:String;
	    public var email:String;
	    public var password:String;
	}
}