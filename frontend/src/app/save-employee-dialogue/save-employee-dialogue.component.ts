import { Component, inject } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-save-employee-dialogue',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './save-employee-dialogue.component.html',
  styleUrl: './save-employee-dialogue.component.scss'
})
export class SaveEmployeeDialogueComponent {
  
  user: any;
  modal = inject(NgbActiveModal);

	employee: any = {
    "id": undefined,
    "username": undefined,
    "password": undefined,
    "email": undefined,
    "address": undefined,
    "firstName": undefined,
    "lastName": undefined,
    "joinDate": undefined,
    "dateOfEntry": undefined,
    "position": undefined,
    "department": undefined,
    "salary": undefined,
    "salaryCurrency": undefined,
    "contractType": undefined,
    "admin": false
  };

  onSubmit() {
    this.modal.close(this.employee);
  }

	close() {
    this.modal.close(undefined);
	}
}