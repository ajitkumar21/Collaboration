var user=angular.module('collaborationAppUser',['controllerUserService','ngRoute']);
user.controller('userController',[ '$scope','UserService','$http',function($scope,UserService,$http){
	var self=this;
	self.userDetails={userDetails_id:'',userName:'',password:'',email:'',gender:'',status:'',gender:'',phoneNo:'',dateOfBirth:''}
	self.userDetailss=[];

	self.submit = submit;
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;


	fetchAllUser();
	function fetchAllUser(){
		UserService
		.fetchAllUser()
		.then(function(data){
			self.userDetailss=data;
		},function (errResponse) {
			console.error('Error while fetching the userDetailss');
		}
		);
	}

	function createUser(userDetails){
		UserService
		.createUser(userDetails)
		.then(
			fetchAllUser,
			function(errResponse){
				console.error('Error while creating userDetails');
			}
			);
	}

	function updateUser(userDetails, userDetails_id){
		UserService
		.updateUser(userDetails, userDetails_id)
		.then(
			fetchAllUser,
			function(errResponse){
				console.error('Error while updating User');
			}
			);
	}

	function deleteUser(userDetails_id){
		UserService
		.deleteUser(userDetails_id)
		.then(
			fetchAllUser,
			function(errResponse){
				console.error('Error while deleting User');
			}
			);
	}
	function submit() {
		if(self.userDetails.userDetails_id===''){
			console.log('Saving New userDetails', self.userDetails);
			createUser(self.userDetails);
		}else{
			console.log('User updated with userDetails_id ', self.userDetails.userDetails_id);
			updateUser(self.userDetails, self.userDetails.userDetails_id);
		}

		reset();
	}
	function edit(userDetails_id){
		console.log('id to be edited', userDetails_id);
		for(var i = 0; i < self.userDetailss.length; i++){
			if(self.userDetailss[i].userDetails_id === userDetails_id) {
				self.userDetails= angular.copy(self.userDetailss[i]);
				break;
			}
		}
	}
	function remove(userDetails_id){
		console.log('id to be deleted', userDetails_id);
        if(self.userDetails.userDetails_id === userDetails_id) {//clean form if the userDetails to be deleted is shown there.
        	reset();
        }
        deleteUser(userDetails_id);
    }
    function reset(){
    	self.userDetails={userDetails_id:'',description:'',userDetailsName:''};
     
    }
    
}]);