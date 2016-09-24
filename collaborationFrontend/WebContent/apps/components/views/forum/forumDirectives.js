var forum=angular.module('collaborationAppForum',[]);
forum.controller('forumController', function(){
	var fm=this;
	fm.toggle=false;
	var forum=[

	{name:"My Forum",title:"Wassap Evryone?" ,
	forumPost:
	[
	{
		forumpst:"hey good to see you"
	},

	{
		forumpst:"thanks, how you doin?"
	},
	
	{
		forumpst:"I'm good, hbu?"
	}

	]
},







];
fm.forum=forum;

});