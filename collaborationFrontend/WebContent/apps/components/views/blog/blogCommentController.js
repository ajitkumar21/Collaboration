var blogComment=angular.module('collaborationAppBlogComment',['controllerAppBlogCommentService','ngRoute']);
blogComment.controller('blogCommentController', ['BlogCommentService', function(BlogCommentService){
    var self=this;
    self.blogComment={blogComment_id:'',description:'',blogComments:''};
    self.blogComments=[];
	self.submitComment=submitComment;
	/*self.reset=reset;
    self.edit=edit;
    self.remove=remove;*/

    fetchAllBlogComment();
    function fetchAllBlogComment(){
    	BlogCommentService
    	.fetchAllBlogComment()
    	.then(function(data){ 
    		self.blogComments=data;
    	},
    	function(errResponse){
    		console.log("Error is occured while fetching the comment");
    	})
    }
    function createBlogComment(blogComment){
		BlogCommentService
		.createBlogComment(blogComment)
		.then(
			fetchAllBlogComment,
			function(errResponse){
				console.error('Error while creating blog');
			}
			);
	}

function submitComment(){
		if (self.blogComment.blogComment_id==='') {
			console.log('blogComment created with blogComment_id',self.blogComment);
			createBlogComment(self.blogComment);
		}else{
			console.log('blogComment updated with the blogComment_id',self.blogComment.blogComment_id)
			updateBlog(self.blogComment, self.blogComment.blogComment_id);
		}
		/*reset();*/
	}
}]);