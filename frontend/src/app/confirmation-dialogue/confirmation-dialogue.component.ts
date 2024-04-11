import { Component, inject } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

// export class NgbdModalConfirmAutofocus {
// 	modal = inject(NgbActiveModal);
// }

// const MODALS: { [name: string]: Type<any> } = {
// 	focusFirst: NgbdModalConfirm,
// 	autofocus: NgbdModalConfirmAutofocus,
// };

@Component({
  selector: 'app-confirmation-dialogue',
  standalone: true,
  imports: [],
  templateUrl: './confirmation-dialogue.component.html',
  styleUrl: './confirmation-dialogue.component.scss'
})
export class ConfirmationDialogueComponent {

  dialogOptions = {
    title: "",
    message: "",
    description: ""
  };
  
  private modalService = inject(NgbActiveModal);

	closeDialog(isYesClicked: boolean) {
		this.modalService.close(isYesClicked);
	}

}
