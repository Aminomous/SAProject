import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Information6Component } from './information6.component';

describe('Information6Component', () => {
  let component: Information6Component;
  let fixture: ComponentFixture<Information6Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Information6Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Information6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
