import { Component, OnInit, inject } from '@angular/core';
import { Router } from 'express';
import { UserService } from '../../user.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { SaveEmployeeDialogueComponent } from '../../save-employee-dialogue/save-employee-dialogue.component';
import { HttpClientModule } from '@angular/common/http';
import { JsUtils } from '../../js-utils';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-salary',
  standalone: true,
  imports: [HttpClientModule,
    CommonModule
  ],
  templateUrl: './admin-salary.component.html',
  styleUrl: './admin-salary.component.scss',
  providers: [HttpClientModule,UserService,JsUtils]
})
export class AdminSalaryComponent implements OnInit {
  
  constructor(private route :Router,
    private userService: UserService
  ) {}
  
  employees: any[] = [];
  currentPage = 0;
  pageSize = 100;

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    const params = {
      searchKey: undefined,
      searchValue: undefined,
      sortBy: "firstName",
      offset: this.currentPage,
      limit: this.pageSize
    };
    this.userService.getEmployees(params).subscribe((data: any) => {
        this.employees = data;
      });
  }

  nextPage(): void {
    this.currentPage++;
    this.loadEmployees();
  }

  prevPage(): void {
    if (this.currentPage > 1) {
      this.currentPage--;
      this.loadEmployees();
    }
  }


  private modalService = inject(NgbModal);
	closeResult = '';

	open() {
		this.modalService.open(SaveEmployeeDialogueComponent, { ariaLabelledBy: 'modal-basic-title', backdrop: false }).result.then(
			(result) => {
				this.closeResult = `Closed with: ${result}`;
			},
			(reason) => {
				this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
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