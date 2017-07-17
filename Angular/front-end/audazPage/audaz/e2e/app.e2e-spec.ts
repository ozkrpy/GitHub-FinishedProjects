import { AudazPage } from './app.po';

describe('audaz App', () => {
  let page: AudazPage;

  beforeEach(() => {
    page = new AudazPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
