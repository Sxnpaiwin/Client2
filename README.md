# [CheatBreakerX/ClientBase](https://github.com/CheatBreakerX/ClientBase)

The base of the CheatBreaker Forge client.

This is to hold main code for the client without having to recode everything for each upcoming or current version supported by the client. This can be changed easily and implemented easily into all versions of the client with minimal effort. This also makes it easy to import, as it uses _no_ Minecraft libraries (AuthLib, Forge libraries, etc.) and therefore cannot be (or is hard to be) unimportable. The same can unfortunately not be said for the actual versions of the mod (RIP 1.7.10) but we have a good idea that Forge or some other person will keep these old versions up at any cost, that's what people for some reason do.