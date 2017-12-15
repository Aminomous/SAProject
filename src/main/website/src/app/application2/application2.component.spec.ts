import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application2Component } from './application2.component';

describe('Application2Component', () => {
  let component: Application2Component;
  let fixture: ComponentFixture<Application2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
