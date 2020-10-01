import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationalPartnerDashBoardComponent } from './educational-partner-dash-board.component';

describe('EducationalPartnerDashBoardComponent', () => {
  let component: EducationalPartnerDashBoardComponent;
  let fixture: ComponentFixture<EducationalPartnerDashBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EducationalPartnerDashBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationalPartnerDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
