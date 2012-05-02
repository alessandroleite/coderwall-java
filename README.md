# Coderwall-java [![endorse](http://api.coderwall.com/alessandroleite/endorsecount.png)](http://coderwall.com/alessandroleite)

Coderwall Java Client API

## Build

```
mvn package jar:jar
```

## Running
```
java -jar target/coderwall-j.jar <username>

##	Output
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
See License.txt for details.