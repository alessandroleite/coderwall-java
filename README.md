# Coderwall-java [![endorse](http://api.coderwall.com/alessandroleite/endorsecount.png)](http://coderwall.com/alessandroleite)

Coderwall Java Client API

## Build

```
mvn package jar:jar
 
```

## Running
```
java -jar target/coderwall-j.jar <username>

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