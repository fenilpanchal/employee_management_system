import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveEmployeeDialogueComponent } from './save-employee-dialogue.component';

describe('SaveEmployeeDialogueComponent', () => {
  let component: SaveEmployeeDialogueComponent;
  let fixture: ComponentFixture<SaveEmployeeDialogueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SaveEmployeeDialogueComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SaveEmployeeDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
