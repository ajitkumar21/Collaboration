var blog=angular.module('collaborationAppBlog', []);
blog.controller('blogController', function($scope){
	

	var bg=this;
	bg.toggle=false;
	var blog=[

	{name:"My Blog",title:"Wassap Evryone?" ,
	blogPost:
	[
	{
		blogpst:"hey good to see you"
	},

	{
		blogpst:"thanks, how you doin?"
	},
	
	{
		blogpst:"I'm good, hbu?"
	}

	]
},







];
bg.blog=blog;

});