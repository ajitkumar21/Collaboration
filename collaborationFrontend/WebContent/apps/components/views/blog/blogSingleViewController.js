var BSV=angular.module('collaborationBlogSingleView',['controllerBlogViewService','ngRoute']);
BSV.controller('blogViewController', ['BlogViewService','$http','$routeParams',function(BlogViewService,$http,$routeParams){
	var self=this;
	self.blogView={blog_id:'',title:'',desscription:'',blog_comments:[{
	blogComment_id:'',description:''}]};
	self.submitComment = submitComment;
	self.blog_comments={blogComment_id:'',description:''};
	self.blog_commentss=[];
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;
	var blog_id=$routeParams.blog_id;
fetchSingleBlog(blog_id);
function fetchSingleBlog(blog_id){
	BlogViewService
	.fetchSingleBlog(blog_id)
	.then(
		function(data){
			self.blogView=data;
		},
		function(errResponse){
			console.log('Error while fetching data from forum');
		});
}

fetchAllComment();
function fetchAllComment(){
	BlogViewService
	.fetchAllComment()
	.then(
		function(data){
		self.blog_commentsS=data;
	},
	function(errResponse){
		console.log('error while  fetch all post');
	});
}
 function createComment(blogView,blog_comments){
 	var blog_id=$routeParams.blog_id;
		BlogViewService
		.createComment(blogView,blog_comments)
		.then(
			fetchSingleBlog(blog_id),
			function(errResponse){
				console.error('Error while creating blog_comments');
			}
			);
	}
	function deleteComment(blogComment_id){
		BlogViewService
		.deleteComment(blogComment_id)
		.then(
			fetchAllComment(),
			function(errResponse){
				console.error('error while delete the blogComment_id',blogComment_id);
			}
			);

	}
	function submitComment(){
		if (self.blog_comments.blogComment_id===''){
		console.log('blogView created with blogComment_id',self.blogView,self.blog_comments);
			createComment(self.blogView,self.blog_comments.description);
		
		}else{
			console.log('blogView updated with the blogComment_id',self.blogView.blogComment_id)
			updateComment(self.blogView, self.blogView.blogComment_id);
		}
		reset();
	}
	function edit(blogComment_id){
		console.log('id to be edited', blogComment_id);
		for(var i = 0; i < self.blog_commentss.length; i++){
			if(self.blog_commentss[i].blogComment_id === blogComment_id) {
				self.blog_comments= angular.copy(self.blog_commentss[i]);
				break;
			}
		}
	}
	function remove(blogComment_id){
		console.log('id to be deleted', blogComment_id);
        if(self.blog_comments.blogComment_id === blogComment_id) {//clean form if the blog_comments to be deleted is shown there.
        	reset();
        }
        deleteComment(blogComment_id);
    }
	function reset(){
		self.blog_comments={blogComment_id:'',description:''};
	}
}]);