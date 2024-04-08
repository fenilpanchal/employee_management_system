import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeSelfComponent } from './employee-self.component';

describe('EmployeeSelfComponent', () => {
  let component: EmployeeSelfComponent;
  let fixture: ComponentFixture<EmployeeSelfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeSelfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeeSelfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
