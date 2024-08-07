import { EHRLandingPage } from './app.po';

describe('EHR App', () => {
  let page: EHRLandingPage;

  beforeEach(() => {
    page = new EHRLandingPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
