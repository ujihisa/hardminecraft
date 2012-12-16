(ns hardminecraft.core
  (:require [twitter.oauth]
            [twitter.api.restful]
            [swank.swank])
  (:import [org.bukkit Bukkit DyeColor Material]
           [org.bukkit.material Wool Dye]
           [org.bukkit.entity Animals Arrow Blaze Boat CaveSpider Chicken
            ComplexEntityPart ComplexLivingEntity Cow Creature Creeper Egg
            EnderCrystal EnderDragon EnderDragonPart Enderman EnderPearl
            EnderSignal ExperienceOrb Explosive FallingSand Fireball Fish
            Flying Ghast Giant HumanEntity IronGolem Item LightningStrike
            LivingEntity MagmaCube Minecart Monster MushroomCow NPC Painting
            Pig PigZombie Player PoweredMinecart Projectile Sheep Silverfish
            Skeleton Slime SmallFireball Snowball Snowman Spider Squid
            StorageMinecart ThrownPotion TNTPrimed Vehicle Villager
            Villager$Profession WaterMob Weather Wolf Zombie Ocelot
            Bat]
           [org.bukkit.event.entity EntityDamageByEntityEvent
            EntityDamageEvent$DamageCause CreatureSpawnEvent$SpawnReason]
           [org.bukkit.potion Potion PotionEffect PotionEffectType]
           [org.bukkit.inventory ItemStack]
           [org.bukkit.util Vector]
           [org.bukkit Location Effect]
           [org.bukkit.block Biome]
           [org.bukkit.event.block Action]
           [org.bukkit.enchantments Enchantment])
  (:import #_(twitter.callbacks.protocols SyncSingleCallback)
           #_([de.ntcomputer.minecraft.controllablemobs.api ControllableMobs]
           [de.ntcomputer.minecraft.controllablemobs.api.actions ActionState
            ActionType]
           [de.ntcomputer.minecraft.controllablemobs.api.aibehaviors
            EntityFilter AIAttackMelee AIAttackRanged AIBehavior AIFleeSun
            AIFloat AILookAtEntity AIRandomLookaround AIRandomStroll
            AIRestrictSun AITargetBehavior AITargetBehaviorEx AITargetHurtBy
            AITargetNearest])))

(defonce plugin* nil)

(defmacro later [& exps]
  `(.scheduleSyncDelayedTask
     (Bukkit/getScheduler)
     hardminecraft.core/plugin*
     (fn [] ~@exps)
     0))

#_(defn periodically25 []
  (doseq [zombie (.getEntitiesByClass (Bukkit/getWorld "world") Zombie)]
    ))

(defonce swank* nil)
(defn on-enable [plugin]
  (def plugin* plugin)
  (when-not swank*
    (def swank* (swank.swank/start-repl 4007)))
  #_(.scheduleSyncRepeatingTask (Bukkit/getScheduler) plugin* #'periodically25 0 25))
