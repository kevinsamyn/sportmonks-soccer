# sportmonks-soccer
Simplify SportMonks Soccer API v2.0 Calling in Java

## Objectif
Cette bibliothèque à pour but de faciliter l'utilisation de l'API Soccer de Sportmonks.com

## Utilisation
### 1 - Récupération d'une instance du client
```java
final APIClient instance = APIClient.getInstance(API_TOKEN);
```
### 2 - Récupération d'un end point
```java
final PreMatchOddsEndPoint ep = instance.getPreMatchOddsEndPointInstance();
```
### 3 - Parametrage de l'appel
```java
final PreMatchOddsEndPointParams params = new PreMatchOddsEndPointParams();
params.setFixtureId(MATCH_ID);
```
### 4 - Appel de l'API
```java
final List<Offer> offers = proxy.findByFixture(params);
```
## Liste des end points disponibles

- LeaguesEndPoint
- ContinentsEndPoint
- CountriesEndPoint
- LivescoresEndPoint
- CommentariesEndPoint
- FixturesEndPoint
- PreMatchOdssEndPoint
- InPlayOddsEndPoint
- SeasonsEndPoint
- PlayersEndPoint
- StandingsEndPoint
- TeamsEndPoint
- VideoHighlightsEndPoint
- TvStationsEndPoint
