import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Information5Component } from './information5.component';

describe('Information5Component', () => {
  let component: Information5Component;
  let fixture: ComponentFixture<Information5Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Information5Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Information5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
