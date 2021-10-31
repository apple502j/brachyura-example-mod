import io.github.coolcrabs.brachyura.fabric.FabricLoader;
import io.github.coolcrabs.brachyura.fabric.FabricMaven;
import io.github.coolcrabs.brachyura.fabric.FabricProject;
import io.github.coolcrabs.brachyura.fabric.Yarn;
import io.github.coolcrabs.brachyura.maven.MavenId;
import net.fabricmc.mappingio.tree.MappingTree;

public class Buildscript extends FabricProject {
	private static final String MC_VERSION = "1.17.1";
	private static final String MC_MAJOR = "1.17";
	private static final String YARN_VERSION = "63";
	private static final String LOADER_VERSION = "0.12.4";
	private static final String FABRIC_VERSION = "0.41.3";

	private static final String MOD_VERSION = "1.0.0";

	@Override
	public String getMcVersion() {
		return MC_VERSION;
	}

	@Override
	public MappingTree createMappings() {
		return Yarn.ofMaven(FabricMaven.URL, FabricMaven.yarn(MC_VERSION + "+build." + YARN_VERSION)).tree;
	}

	@Override
	public FabricLoader getLoader() {
		return new FabricLoader(FabricMaven.URL, FabricMaven.loader(LOADER_VERSION));
	}

	@Override
	public String getModId() {
		return "fabric-example-mod";
	}

	@Override
	public String getVersion() {
		return MOD_VERSION + "+" + MC_MAJOR;
	}

	@Override
	public void getModDependencies(ModDependencyCollector d) {
		d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-api", FABRIC_VERSION + "+" + MC_MAJOR), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
	}
}
