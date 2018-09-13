import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewApplyedJobComponent } from './view-applyed-job.component';

describe('ViewApplyedJobComponent', () => {
  let component: ViewApplyedJobComponent;
  let fixture: ComponentFixture<ViewApplyedJobComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewApplyedJobComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewApplyedJobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
