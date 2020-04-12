Birdie - A Kotlin Telegram Bot
==============================

<!-- TODO: Add badges and whatnot -->

Birdie is a heavily WIP Telegram Bot, written in Kotlin, running on a JVM host

Features
--------

- Easy extensibility via plugins
- Built in plugin manager
- Cool web admin interface
- Easy to deploy and update

Usage
-----

Deploying Birdie (once it is ready to be used) is quite simple using the supplied [Dockerfile](./Dockerfile) 
and [docker-compose](./docker-compose.yml) configurations.

By default, Birdie will use an in-memory, volatile database. To have it regularly backed up, make sure to 
attach the `/config` volume - it will store your configuration files, as well as the database and plugins.


Plugin Interface
----------------

Plugins are loaded using the [PF4J](https://pf4j.org/) framework. All plugins must use the architecture 
provided in [the sample plugin](./plugins/sample) to ensure compatibility.

Plugins can be enabled/disabled/configured from the web interface.

At this moment, plugins can:

- Intercept and handle Telegram messages
- Display a web interface on the admin panel for easier management
- Save and load configuration of the plugin

Planned features:
- More extensive configuration object instead of a single string
- Access to the database