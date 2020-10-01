import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEducationCentersComponent } from './all-education-centers.component';

describe('AllEducationCentersComponent', () => {
  let component: AllEducationCentersComponent;
  let fixture: ComponentFixture<AllEducationCentersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllEducationCentersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllEducationCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
