import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Application8Component } from './application8.component';

describe('Application8Component', () => {
  let component: Application8Component;
  let fixture: ComponentFixture<Application8Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Application8Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Application8Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
