import { TestBed } from '@angular/core/testing';

import { RoomSeviceService } from './room-sevice.service';

describe('RoomSeviceService', () => {
  let service: RoomSeviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoomSeviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
