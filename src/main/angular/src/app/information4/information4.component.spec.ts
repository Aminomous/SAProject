import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Information4Component } from './information4.component';

describe('Information4Component', () => {
  let component: Information4Component;
  let fixture: ComponentFixture<Information4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Information4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Information4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
