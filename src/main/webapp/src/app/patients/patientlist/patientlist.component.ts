import { Component, OnInit, AfterViewInit, AfterContentInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientDetailsService } from '../services/patientDetailsService';
import { Data } from '../../data';
import { NgxSpinnerService } from 'ngx-spinner';
import { PatientRecord } from '../models/PatientRecord';
import { LoginService } from '../../home/login/login.service';
import { CurrentUserService } from '../..//profiles/currentUserService';
import { StaffMember } from '../../administration/staff-members/staffmember';
declare interface DataTable {
    headerRow: string[];
    footerRow: string[];
    dataRows: string[][];
}

declare const $: any;

@Component({
    selector: 'ehr-patientlist',
    templateUrl: './patientlist.component.html',
    styleUrls: [ '../../app.component.css']
})

export class PatientListComponent implements OnInit {
    statusCode!: number;
    processValidation = false;
    requestProcessing = false;
    fullName: any;
    selected: any;
    disable: boolean = false;
    userRole!: string;
    loggedInUser!: StaffMember;
    patient!: PatientRecord[];
    msgName: any;
    public dataTable: DataTable = {
        headerRow: ['Patient Name', 'MRN', 'Sex', 'DOB', 'Primary Care Provider', 'Patient Street Address', 'Encounter', 'Actions', 'Status'],
        footerRow: ['Patient Name', 'MRN', 'Sex', 'DOB', 'Primary Care Provider', 'Patient Street Address', 'Encounter', 'Actions', 'Status'],

        dataRows: []
    };
    primaryProvider: any;

    constructor(private router: Router,
        private patientDetailsService: PatientDetailsService,
        private sharedData: Data,
        private loginService: LoginService,
        private currentUserService: CurrentUserService,
        private spinner: NgxSpinnerService) { }

    ngOnInit() {
        if (this.sharedData.msgName != undefined) {
            this.fullName = this.sharedData.successMsg;
            this.msgName = this.sharedData.msgName;
            this.statusCode = this.sharedData.statusCode;
            this.sharedData.msgName = undefined;
        }

        this.setTimeOut();
        this.setLoginDate();
        // this.getAllPatients();
    }

    setLoginDate() {
        this.currentUserService.getCurrentStaffMember()
            .subscribe(data => {
                this.loggedInUser = data;
                this.userRole = this.loggedInUser.designation;
                this.getAllPatients(this.userRole);
            })
    }

    setTimeOut() {
        window.setTimeout(function () {
            $(".alert").fadeTo(2000, 500).slideUp(500, function () {
                $(".alert").slideUp(500);
            });
        }, 4000);
    }

    getAllPatients(userRole: string) {
        this.spinner.show();
        var self = this;
        if (this.userRole == 'TRY_ME') {
            this.patientDetailsService.getAllPatientsByUserId()
                .subscribe((data: any) => {
                    //console.log(data);
                    this.spinner.hide();
                    this.disable = false;
                    $('#datatables').DataTable().destroy();
                    this.dataTable.dataRows = <any>data;
                    setTimeout(function () {
                        self.initTable();
                    }, 10);
                })
        } else {
            this.patientDetailsService.getAllPatients()
                .subscribe((data: any) => {
                  //  console.log(data);
                    this.spinner.hide();
                    this.disable = false;
                    $('#datatables').DataTable().destroy();
                    this.dataTable.dataRows = <any>data;
                    setTimeout(function () {
                        self.initTable();
                    }, 10);
                })
        }
    }

    DateOfBirth(date: string | number | Date) {
        return new Date(date);
    }

    LastUpdated(date: string | number | Date) {
        return new Date(date);
    }

    disabled(addinfo: any) {
        if (addinfo == "Deceased" || addinfo == "Inactive") {
            return true;
        }
        else {
            return false;
        }
    }

    displayPatientAddress(patient: PatientRecord) {
        if (patient.patientApartmentNo == null && patient.patientStreetAddress!=null) {
            patient.patientApartmentNo = "";
            return patient.patientApartmentNo + " " + patient.patientStreetAddress + ", " + patient.patientCity + ", " + patient.patientState + " - " + patient.zipCode;
        } else if (patient.patientApartmentNo == null && patient.patientCity == null && patient.patientStreetAddress == null && patient.patientStreetAddress == null) {
            return "";
        } else {
            return patient.patientApartmentNo + " " + patient.patientStreetAddress + ", " + patient.patientCity + ", " + patient.patientState + " - " + patient.zipCode;
        }
    }

    addPatient() {
        this.router.navigate(['/patients/newpatient']);
    }

    openUpdatePatient(patientId: number) {
        this.router.navigate(['/patients/update/' + patientId]);
    }

    closeModal() {
        $('.modal').modal('hide');
    }

    openModal() {
        $('.modal').modal('show');
    }

    preProcessConfigurations() {
        this.statusCode = 0;
        this.requestProcessing = true;
    }

    private initTable() {
        var table = $('#datatables').DataTable({
            "ordering": true,
            columnDefs: [
                { orderable: false, targets: [6, 7] },
                { searchable: false, targets: [1, 2, 4, 5, 8] }
            ],
            "language": {
                "emptyTable": " "
            },
            "info": false,
            "bLengthChange": false,
            "dom": 'lrtip',

            "createdRow": function (row: any, data: string[], dataIndex: any) {
                if (data[8] == "Active") {
                    $(row).css('color', 'black');
                    //console.log(data[6]);

                    // $(row).attr("disabled",true);
                }
                else if (data[8] == "Inactive") {
                    $(row).css('color', '#33cc33');
                    $(row).css('font-weight', '500');
                }
                else {
                    $(row).css('color', 'red');

                }
                // if(data[8]=="Active")
                // {
                //     $(data[6]).css("visible",'hidden');
                // }

            }
        });


        // Delete a record
        table.on('click', '.remove',  (e: any) => {
            const $tr = $(this).closest('tr');
            table.row($tr).remove().draw();
            e.preventDefault();
        });


        $('table').removeClass('dataTable');

    }

    //Redirection for Patient History
    loadHistory(patientId: number) {
        this.router.navigate(['/patients/addencounter/' + patientId]);
    }

    datepicker(val: string) {
        var self = this;
        $("#" + val).datepicker({
            Style: "padding-top:10px;",
            changeMonth: true,
            yearRange: "1900:+0",
            defaultDate: '01/01/1953',
            maxDate: new Date(),
            changeYear: true,
            beforeShow: function () {
                setTimeout(function () {
                    $('.ui-datepicker').css('z-index', 99999999999999);
                }, 0);
            },


        }).datepicker("show");

        $( () => {
            $("#" + val).datepicker();
            $("#" + val).on("change",  () => {
                this.selected = $(this).val();
                var table = $('#datatables').DataTable();
                table.search(this.selected).draw();
            });
        });
    }

    searchdata(val: { target: { value: string; }; }) {
        var hasNumber = /\d/;
        var table = $('#datatables').DataTable();
        if (!hasNumber.test(val.target.value)) {
            table.search(val.target.value).draw();
        }
    }

    changePage(x: { target: { value: number; }; }) {
        if (x.target.value == -1) {
            $('#datatables').DataTable().destroy();
            $('#datatables').DataTable({
                "pagingType": "full_numbers",
                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                "dom": '<lrt<t>p>',
                "pageLength": -1,
                "bLengthChange": false,
            });
        }
        else {
            $('#datatables').DataTable().destroy();
            $('#datatables').DataTable({
                "dom": '<lrt<t>p>',
                "pageLength": x.target.value,
                "bLengthChange": false,
            });
        }
    }

}