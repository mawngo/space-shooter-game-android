# Asteroids Game Android

[Play Online](https://mawngo.github.io/space-shooter-game/) | [Download](https://github.com/mawngo/space-shooter-game-android/releases/latest)

Android wrapper for [Space Shooter Game](https://github.com/mawngo/space-shooter-game)

## Development

Require Java 17.

### Build

Generate `apk`:

```shell
./gradlew assembleRelease
```

Generate `universal apk`

```shell
./gradlew :app:packageReleaseUniversalApk
```

### Signing

To generate `singed apk`, generate put the `keystore.jks` file under project root.

Set the following environment variables:

| Variable Name          | Description                                        |
|------------------------|----------------------------------------------------|
| SIGNING_STORE_PASSWORD | The password to your signing keystore              |
| SIGNING_KEY_ALIAS      | The alias of your signing key                      |
| SIGNING_KEY_PASSWORD   | The private key password for your signing keystore |

Then run build commands:

```shell
./gradlew assembleRelease
#...
```

For more detail, check the [build.gradle.kts](app/build.gradle.kts) file.