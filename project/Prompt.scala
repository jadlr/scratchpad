import sbt.{ Project, State }

object Prompt {

  val format: State => String = { state ⇒
    s"[${scala.Console.CYAN}%s${scala.Console.RESET}] λ ".format {
      Project.extract(state).getOpt(sbt.Keys.name).getOrElse {
        Project.extract(state).currentProject.id
      }
    }
  }

}
