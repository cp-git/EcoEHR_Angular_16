export class ICD10Group {
    constructor(
        public groupId: number, 
        public groupRange: string, 
        public groupDescription: string,
        public createdDate: Date,
        public createdBy: string,
        public lastUpdatedDate: Date,
        public lastUpdatedBy: string,
        public count: number){}
}