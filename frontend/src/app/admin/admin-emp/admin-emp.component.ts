import { Component, OnInit, TemplateRef, inject } from '@angular/core';
import { AdminSidebarComponent } from '../common/admin-sidebar/admin-sidebar.component';
import { JsUtils } from '../../js-utils';
import { Router } from '@angular/router';
import { UserService } from '../../user.service';
import { HttpClientModule, HttpResponse } from '@angular/common/http';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DropdownComponent } from '../../dropdown/dropdown.component';

@Component({
  // host: {ngSkipHydration: 'true'},
  selector: 'app-admin-emp',
  standalone: true,
  imports: [AdminSidebarComponent,
    HttpClientModule
  ],
  templateUrl: './admin-emp.component.html',
  styleUrl: './admin-emp.component.scss',
  providers: [HttpClientModule, UserService, JsUtils]
})
export class AdminEmpComponent implements OnInit {
  
  constructor(private route :Router,
    private userService: UserService
  ) {}
  
  employees: any[] = [
    { id: 1, "firstName": "Dilip"}
  ];
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
    this.userService.getEmployees(params)
    .subscribe((data: any) => {
      console.info(data.body);
      // Condition: isAdmin
      if (data.body && data.body.admin == true) {
        this.employees = data.body.content;
      }
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

  // logout(){
  //   console.log ('leave')
  //   this.userService.logout().subscribe((data:any)=>{
  //     console.info(data);
  //     this.route.navigate(['/'])
  //   })
    
  // }
  // user(user: any) {
    
  // }
  

  private modalService = inject(NgbModal);
	closeResult = '';

	open() {
		this.modalService.open(DropdownComponent, { ariaLabelledBy: 'modal-basic-title', backdrop: false }).result.then(
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
