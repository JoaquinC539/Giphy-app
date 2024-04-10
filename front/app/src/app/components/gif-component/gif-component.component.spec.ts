import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GifComponentComponent } from './gif-component.component';

describe('GifComponentComponent', () => {
  let component: GifComponentComponent;
  let fixture: ComponentFixture<GifComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GifComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GifComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
