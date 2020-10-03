import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSelectedCourseComponent } from './view-selected-course.component';

describe('ViewSelectedCourseComponent', () => {
  let component: ViewSelectedCourseComponent;
  let fixture: ComponentFixture<ViewSelectedCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewSelectedCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSelectedCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
