# Coderwall-java [![endorse](http://api.coderwall.com/alessandroleite/endorsecount.png)](http://coderwall.com/alessandroleite) [![Build Status](https://secure.travis-ci.org/alessandroleite/coderwall-java.png)](http://travis-ci.org/alessandroleite/coderwall-java)

Coderwall Java Client API

## Build

```
mvn package
```

## Running
```
java -jar target/coderwall-j.jar <username>

##	Output example
User: alessandroleite Location: Brazil 
Achievements:
- Charity: Fork and commit to someone's open source project in need
- T-Rex: Have at least one original repo where C is the dominant language
- Komodo Dragon 3: Have at least three original repos where Java is the dominant language
- Komodo Dragon: Have at least one original repo where Java is the dominant language
- Forked: Have a project valued enough to be forked by someone else

```

## Usage

```
Coder coder = new CoderwallClient("alessandroleite").get();

for (Badge badge : coder.getBadges()) 
{
	System.out.printf("- %s: %s\n", badge.getName(), badge.getDescription());
}

```

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b your-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin your-new-feature`)
5. Create new Pull Request

## License 

The project is licensed under the MIT license. 

Copyright (c) 2012 Contributors

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

