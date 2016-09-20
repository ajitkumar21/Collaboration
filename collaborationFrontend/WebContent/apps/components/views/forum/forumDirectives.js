var forum=angular.module('collaborationAppForum',[]);
forum.controller('forumController', function(){
	var fm=this;
	fm.toggle=false;
	var forum=[

	{name:"firstForum",title:"Hello this is first forum" ,
	forumPost:
	[
	{
		forumpst:"hi hello everone"
	}
	]
},
{name:"secondForum",title:"Hello this is first forum" ,
forumPost:
[{
	forumpst:"hi hello everone"
}]},
{name:"thirdForum",title:"Hello this is first forum" ,
forumPost:
[{forumpst:"hi hello everone"},{forumpst:"how are you?"}]
},
{name:"fourthForum",title:"Hello this is first forum" ,
forumPost:
[{
	forumpst:"hi hello everone"
}]}

];
fm.forum=forum;

});