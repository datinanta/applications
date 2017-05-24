import { DatinantaPage } from './app.po';

describe('datinanta App', function() {
  let page: DatinantaPage;

  beforeEach(() => {
    page = new DatinantaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
