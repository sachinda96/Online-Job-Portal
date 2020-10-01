import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationCentersComponent } from './education-centers.component';

describe('EducationCentersComponent', () => {
  let component: EducationCentersComponent;
  let fixture: ComponentFixture<EducationCentersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EducationCentersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
