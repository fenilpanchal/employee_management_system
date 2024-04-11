import { Component, NgModule, OnInit, TemplateRef, inject, model } from '@angular/core';
import { AdminSidebarComponent } from '../common/admin-sidebar/admin-sidebar.component';
import { JsUtils } from '../../js-utils';
import { Router } from '@angular/router';
import { UserService } from '../../user.service';
import { HttpClientModule } from '@angular/common/http';
import { ModalDismissReasons, NgbModal, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { SaveEmployeeDialogueComponent } from '../../save-employee-dialogue/save-employee-dialogue.component';
import { CommonModule } from '@angular/common';
import { ConfirmationDialogueComponent } from '../../confirmation-dialogue/confirmation-dialogue.component';

@Component({
  // host: {ngSkipHydration: 'true'},
  selector: 'app-admin-emp',
  standalone: true,
  imports: [AdminSidebarComponent,
    HttpClientModule,
    CommonModule,
    NgbPaginationModule
  ],
  templateUrl: './admin-emp.component.html',
  styleUrl: './admin-emp.component.scss',
  providers: [HttpClientModule, UserService, JsUtils]

})
export class AdminEmpComponent implements OnInit {

  private modalService = inject(NgbModal);

  constructor(private route :Router,
    private userService: UserService
  ) {}
  
  employees: any[] = [];
  
  employeeSearchOptions = {
    searchKey: undefined,
    searchValue: undefined,
    sortBy: "firstName",
    offset: 0,
    limit: 10,
    totalElements: 0,
    totalPages: 0,
    previousPage: 0
  };
  currentPage = 0;

  ngOnInit(): void {
    // this.loadEmployees(this.employeeSearchOptions);
    // this.pageChange(0);
  }

  pageChange(page: number) {
    this.employeeSearchOptions.offset = page - 1;
    this.loadEmployees(this.employeeSearchOptions);
  }

  loadEmployees(employeeSearchOptions: any): void {
    this.userService.getEmployees(employeeSearchOptions).subscribe((data: any) => {
      this.employees = data.body.content;
      this.employeeSearchOptions.totalElements = data.body.totalElements;
    });
  }

  // nextPage(): void {
  //   this.currentPage++;
  //   this.loadEmployees();
  // }

  // prevPage(): void {
  //   if (this.currentPage > 1) {
  //     this.currentPage--;
  //     this.loadEmployees();
  //   }
  // }


	open(employee:any) {
		const modalRef=this.modalService.open(SaveEmployeeDialogueComponent, { ariaLabelledBy: 'modal-basic-title', backdrop: false });
    modalRef.componentInstance.employee=employee;
    modalRef.result.then(
			(result) => {
        if (result != undefined) {
          this.userService.addEmployee(result).subscribe(data => {
            this.loadEmployees(this.employeeSearchOptions);
          }); 
        }
			},
			(reason) => {
        console.log(reason);
			},
		);
	}


  deleteEmployee(empployee: any){
		const modalRef=this.modalService.open(ConfirmationDialogueComponent, { ariaLabelledBy: 'modal-basic-title', backdrop: false });
    modalRef.componentInstance.dialogOptions = {
      title: "Delete Employee",
      message: "Are you sure you want to delete `" + empployee.username + "` employee?"
    };
    modalRef.result.then(
			(result) => {
        if (result == true) {
          this.userService.deleteEmployee(empployee.id).subscribe((response: any) => {
            console.log('Data delete seccessfully',response);
            this.loadEmployees(this.employeeSearchOptions);
            
          },
          (error: any) => {
            console.error('Error deleteing data',error);
          }
        );
        }
			},
			(reason) => {
        console.log(reason);
			},
		);
  }

	private getDismissReason(reason: any): string {
		switch (reason) {
			case ModalDismissReasons.ESC:
				return 'by pressing ESC';
			case ModalDismissReasons.BACKDROP_CLICK:
				return 'by clicking on a backdrop';
			default:
				return `with: ${reason}`;
		}
	}
}
