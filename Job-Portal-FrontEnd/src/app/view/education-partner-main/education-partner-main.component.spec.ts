import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationPartnerMainComponent } from './education-partner-main.component';

describe('EducationPartnerMainComponent', () => {
  let component: EducationPartnerMainComponent;
  let fixture: ComponentFixture<EducationPartnerMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EducationPartnerMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationPartnerMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
