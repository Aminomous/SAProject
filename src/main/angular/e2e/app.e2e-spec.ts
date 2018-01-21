import { MyauthappPage } from './app.po';

describe('myauthapp App', () => {
  let page: MyauthappPage;

  beforeEach(() => {
    page = new MyauthappPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
