export class StudentMembers {
    constructor(
        // 1] First name+last name...2]email...3]dob...4]gender.....5].Active status..6]active bttn
		public staffId:number,
		public organizationId: number,

		public staff_role_id: number,

		public firstName : string,
		public lastName: string,
		public designation: string,

		public email:string,
		public staffRoleId: number,
		public staffrole: string,

		public activeFlag: string,
		public paymentStatus: string,
		
		public dob: Date,
		public gender: string
	 ) { 
    }
 } 